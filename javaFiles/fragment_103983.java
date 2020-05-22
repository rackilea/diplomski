@Autowired
  SolrSubscriptionsRepository solrSubscriptionsRepository; 

  @GetMapping("/subscriptions/{subscriptionId}")
  public Subscriptions getSubscriptions(@PathVariable Long subscriptionId) {

    solrSubscriptionsRepository.findSubscriptions(subscriptionId);
    return solrSubscriptionsRepository.findById(subscriptionId);
  }