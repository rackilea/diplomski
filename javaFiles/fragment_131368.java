@Transactional
public void createCoupon() {
Coupon coupon = new Coupon();
coupon.setCode(RandomStringUtils.randomAlphanumeric(5));
coupon.setValidity(1);
coupon = couponRepository.save(coupon);//save will return the managed entity

CouponHistory couponHistory = new CouponHistory();
couponHistory.setCreatedOn(new Date());
couponHistory.setCoupon(coupon);
couponHistoryRepository.save(couponHistory);
}