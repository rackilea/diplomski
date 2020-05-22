@XmlElements(value = {
    @XmlElement(type=FTPSend.class, name="FTPSend"),
    @XmlElement(type=SFTPSend.class, name="SFTPSend"),
    @XmlElement(type=MailSend.class, name="MailSend"),
    @XmlElement(type=ServerToServerSend.class, name="ServerToServerSend")
})
ArrayList<IAction> actionsList = new ArrayList<IAction>();