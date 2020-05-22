val user = User(1L, "email@email.email")
val bundle = Bundle().apply {
    putLong("userId", user.id)
    putString("userEmail", user.email)
    putParcelable("user", user)
}

val userId = bundle.getLong("userId")
val userEmail = bundle.getString("userEmail")
val user1: User? = bundle.getParcelable("user")