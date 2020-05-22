PDU_RSC_DATA pRscData = new PDU_RSC_DATA();
    pRscData.BusTypeId = 1;
    pRscData.ProtocolId = 7;
    pRscData.NumPinData = 2; 

    PDU_PIN_DATA pDLCPinData = new PDU_PIN_DATA();

    PDU_PIN_DATA[] pDLCPinDataArray= (PDU_PIN_DATA[])pDLCPinData.toArray(pRscData.NumPinData);

    pDLCPinDataArray[0].DLCPinNumber = 6;
    pDLCPinDataArray[0].DLCPinTypeId = 1;
    pDLCPinDataArray[1].DLCPinNumber = 14;
    pDLCPinDataArray[1].DLCPinTypeId = 2;

    pDLCPinData.autoWrite();

    Pointer ptr_pDLCPinData = pDLCPinData.getPointer();
    pRscData.pDLCPinData = ptr_pDLCPinData;