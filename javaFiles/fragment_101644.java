Transport transport = session.getTransport("smtp");
transport.connect(this._properties.getProperty("mail.smtp.host"), 
Integer.parseInt(this._properties.getProperty("mail.smtp.port")),
    this._properties.getProperty("mail.smtp.user"),
    this._properties.getProperty("mail.smtp.password"));

Address[] addr = new Address[this._addresses.size()];
for (int i = 0, c = this._addresses.size(); i < c; i++)
{
    addr[i] = new InternetAddress(this._addresses.get(i));
}

transport.sendMessage(message, addr);