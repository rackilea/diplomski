public void initialize(){ //added after James_D comment about initialize()
    clmID.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
    clmTicketName.setCellValueFactory(new PropertyValueFactory<>("ticketName"));
    clmLastName.setCellValueFactory(new PropertyValueFactory<>("ticketLastName"));
    clmCategory.setCellValueFactory(new PropertyValueFactory<>("ticketCategory"));
    clmFirstName.setCellValueFactory(new PropertyValueFactory<>("ticketFirstName"));
}