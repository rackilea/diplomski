public void onClick(View view) {
    switch (view.getId()) {
        case R.id.send_command:
            byte[] commandPacket = new byte[2];
            commandPacket[0] =0x12;
            commandPacket[1] =0x34;
            Usb_Communication usbCom = new Usb_Communication();
            usbCom.Send_message(commandPacket);
            break;
    }
}