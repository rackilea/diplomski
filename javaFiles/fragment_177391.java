ComboBox accountStatusChoice = new ComboBox();

accountStatusChoice.setCaption(MessageResource.getLocalizedString("caption.accountStatus"));
accountStatusChoice.setRequired(true);
accountStatusChoice.setRequiredError(MessageResource.getLocalizedString("error.required.accountStatus"));
accountStatusChoice.setImmediate(true);

for (AccountStatus accountStatus : AccountStatus.values()) {
    accountStatusChoice.addItem(accountStatus);
    accountStatusChoice.setItemCaption(accountStatus, MessageResource.getLocalizedString(accountStatus.name()));
}

return accountStatusChoice;