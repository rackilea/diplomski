if (memberCardNo != null && cardList != null) {
        if (cardList
            .stream()
            .allMatch(card -> !card.get("CardNO").equals(memberCardNo))) {
            memberLogic.updateMemberInfo(id, cardList.get(0).get("CardNO"));
        }
    }