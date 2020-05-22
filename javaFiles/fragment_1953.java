public Voucher fetch(Product product) {
    Voucher voucher=voucherRepository.findTop1ByUsedFalseAndProductOrderByIdAsc(product);
    if(voucher==null)
       return null;
    voucherRepository.lock(voucher, LockModeType.PESSIMISTIC_WRITE);
    voucher.setUsed(true);
    voucherRepository.save(voucher);
    return voucher;
}