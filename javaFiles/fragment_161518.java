public void read() {
    // read from native memory, populate tag
    super.read(); 
    // set union type based on tag
    switch(tag) {
    case XL_RECEIVE_MSG:
    case XL_TRANSMIT_MSG: 
        tagData.setType(s_xl_can_msg.class);
        break;
    case XL_CHIP_STATE: 
        tagData.setType(s_xl_chip_state.class);
        break;
    case XL_LIN_MSG: 
        tagData.setType(s_xl_lin_msg_api.class);
        break;
    // ... add other cases here...
    default:
        // add default type or throw exception etc.  
        break;
    }
    // now read tagData from native memory
    tagData.read();
}