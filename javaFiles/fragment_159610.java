Invitation invitation = new Invitation();
    invitation.setSender_id(mUserId);
    invitation.setDate(date);
    invitation.setInvitee_no(contact.getmMobileNo());
    invitation.setStatus("0");
    invitation.setUser_name(contact.getmUserName());

    invitationArrayList.add(invitation);