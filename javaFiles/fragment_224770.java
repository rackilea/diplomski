RewardServices service = new RewardServicesImpl();
for (int i = 0; i < array.size(); i++) {
    GetAccountRewardSummaryRequest request = new GetAccountRewardSummaryRequest();
    request.accountKey =  new AccountIdDTO(array.get(i)); 
    AccountRewardSummaryDTO result = service.getAccountRewardSummary(request);
    System.out.println(result.rewards.get(6));
}