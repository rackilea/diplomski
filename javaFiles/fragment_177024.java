BREAK_POINT:
    if (memberCardNo != null && cardList != null) {
        for (Map<String, Object> card : cardList) {
            if (card.get("CardNO").equals(memberCardNo)) {
                break BREAK_POINT;
            }
            memberLogic.updateMemberInfo(id, cardList.get(0).get("CardNO"));
        }
    }