class RateInterceptor {
    def getRate(SomeClass businessEntity) {
        return businessEntity.getDiscount() == .5 ? .5 : null
    }
}

return new RateInterceptor().getRate(context)