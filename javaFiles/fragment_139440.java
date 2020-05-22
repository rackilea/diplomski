StringBuilder output = new StringBuilder(128);
output.append("Name: ").append(this.Name);
output.append("Address: ").append(this.Address);
output.append("Balance: ").append(this.balance);
output.append("Minutes used").append(this.minutes);
output.append("Texts Sent: ").append(this.texts);
output.append("Cost per Minute: ").append(this.unitMinuteCost);
output.append("Cost per Text: ").append(this.unitTextCost);

return output.toString();