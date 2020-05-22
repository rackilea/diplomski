Set<String> smId =
               (Set<String>) httpSession.getAttribute(AppConstants.SEARCH_HOLDING_MEMBER_IDS);
        if (!smId.isEmpty()) {
            List<Account> holdingMemberList =
                    (List<Account>) httpSession.getAttribute("memberList");
            for (Account account : holdingMemberList) {
                if (smId.contains(account.getMemberId())) {
                    selectedMemberList.add(account);
                }
            }
            result = AppConstants.SELECTED; 
        }