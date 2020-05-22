case playState_ReadData:
            int result;
            index = oggSyncState_.buffer(bufferSize_);
            buffer = oggSyncState_.data;
            bytes = readFromStream(buffer, index, bufferSize_);
            if (TDebug.TraceAudioConverter) {
                TDebug.out("More data : " + bytes);
            }
            // has no data in buffer also
            if (bytes == -1 && bufferSize_ - index == 0) {
                playState = playState_Done;
                if (TDebug.TraceAudioConverter) {
                    TDebug.out("Ogg Stream empty. Settings playState to playState_Done.");
                }
                break;
            }
            else {
                if (bytes != -1) {
                    oggSyncState_.wrote(bytes); 
                }
                if (bytes == 0 && bufferSize_ - index == 0) {
                    if ((oggPage_.eos() != 0) || (oggStreamState_.e_o_s != 0) || (oggPacket_.e_o_s != 0)) {
                        if (TDebug.TraceAudioConverter) {
                            TDebug.out("oggSyncState wrote 0 bytes: settings playState to playState_Done.");
                        }
                        playState = playState_Done;
                    }
                    if (TDebug.TraceAudioConverter) {
                        TDebug.out("oggSyncState wrote 0 bytes: but stream not yet empty.");
                    }
                    break;
                }
            }

            result = oggSyncState_.pageout(oggPage_);
            if (result == 0) {
                if (TDebug.TraceAudioConverter) {
                    TDebug.out("Setting playState to playState_ReadData.");
                }
                playState = playState_ReadData;
                break;
            } // need more data
            if (result == -1) { // missing or corrupt data at this page position
                if (TDebug.TraceAudioConverter)
                    TDebug.out("Corrupt or missing data in bitstream; setting playState to playState_ReadData");
                playState = playState_ReadData;
                break;
            }

            oggStreamState_.pagein(oggPage_);

            if (TDebug.TraceAudioConverter)
                TDebug.out("Setting playState to playState_WriteData.");
            playState = playState_WriteData;
            break;