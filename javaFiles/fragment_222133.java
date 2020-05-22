HRESULT Sidetone::WalkTreeBackwardsFromPart(IPart *part) {

    HRESULT hr;

    if (wcscmp(this->getPartName(part), L"SuperMix") == 0 && this->treePeek(part, L"Volume")){

        this->superMix = part;

        IPart** superMixChildren = this->getChildParts(part);
        int nSuperMixChildren = sizeof(superMixChildren) / sizeof(superMixChildren[0]);
        if (nSuperMixChildren > 0){

            for (int i = 0; i < nSuperMixChildren; i++){

                if (wcscmp(this->getPartName(superMixChildren[i]), L"Volume") == 0){

                    this->volumeNode = this->getIPartAsIAudioVolumeLevel(superMixChildren[i]);
                    if (this->volumeNode != NULL){

                        IPart** volumeNodeChildren = this->getChildParts(superMixChildren[i]);
                        int nVolumeNodeChildren = sizeof(volumeNodeChildren) / sizeof(volumeNodeChildren[0]);
                        if (nVolumeNodeChildren > 0){

                            for (int j = 0; j < nVolumeNodeChildren; j++){

                                if (wcscmp(this->getPartName(volumeNodeChildren[j]), L"Mute") == 0){

                                    this->muteNode = this->getIPartAsIAudioMute(volumeNodeChildren[j]);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        delete[] superMixChildren;


        this->muteNode; // = someotherfunc();
        this->superMixFound = true;
        return S_OK;

    } else if(superMixFound == false){

        IPartsList *pIncomingParts = NULL;
        hr = part->EnumPartsIncoming(&pIncomingParts);
        if (E_NOTFOUND == hr) {
            // not an error... we've just reached the end of the path
            //printf("%S - No incoming parts at this part: 0x%08x\n", this->MSGIDENTIFIER, hr);
            return S_OK;
        }
        if (FAILED(hr)) {
            printf("%S - Couldn't enum incoming parts: hr = 0x%08x\n", this->MSGIDENTIFIER, hr);
            return hr;
        }
        UINT nParts = 0;
        hr = pIncomingParts->GetCount(&nParts);
        if (FAILED(hr)) {
            printf("%S - Couldn't get count of incoming parts: hr = 0x%08x\n", this->MSGIDENTIFIER, hr);
            pIncomingParts->Release();
            return hr;
        }

        // walk the tree on each incoming part recursively
        for (UINT n = 0; n < nParts; n++) {
            IPart *pIncomingPart = NULL;
            hr = pIncomingParts->GetPart(n, &pIncomingPart);
            if (FAILED(hr)) {
                printf("%S - Couldn't get part #%u (0-based) of %u (1-basedSmile hr = 0x%08x\n", this->MSGIDENTIFIER, n, nParts, hr);
                pIncomingParts->Release();
                return hr;
            }

            hr = WalkTreeBackwardsFromPart(pIncomingPart);
            if (FAILED(hr)) {
                printf("%S - Couldn't walk tree on part #%u (0-based) of %u (1-basedSmile hr = 0x%08x\n", this->MSGIDENTIFIER, n, nParts, hr);
                pIncomingPart->Release();
                pIncomingParts->Release();
                return hr;
            }
            pIncomingPart->Release();
        }

        pIncomingParts->Release();
    }

    return S_OK;
}