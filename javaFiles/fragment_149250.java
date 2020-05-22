public interface PaymentRepository{

    PaymentEntity getPaymentById(long id);
    List<PaymentEntity> getAllPayments();
}


public interface UserRepository{

    UserEntity getUserById(long id);
    List<UserEntity> getAllUsers();
}