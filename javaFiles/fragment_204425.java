private void m_jbShowSelAccResultsActionPerformed(java.awt.event.ActionEvent evt) {                                                      
    Account selAcc = getSelectedAccount();

    if(selAcc != null) {
        accPanel.setAccount(Account.getDeepCopy(selAcc));
        cardLayout.show(cardHolderPanel, "Account View");
    }
    else {
        showErrorMessage("Please select an account to view");
    }
}