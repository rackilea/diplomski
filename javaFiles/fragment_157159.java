message User {
    required string firstName = 1;
    required string secondName = 2;

    message UserDetails {
        required int age = 1;
        required int weight = 2;
        required int lenght = 3;
    }

    required UserDetails details = 3;
}