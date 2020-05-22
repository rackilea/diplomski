if (task.isSuccessful()) {
    Toast.makeText(Register_User.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
} else {
    Log.w(TAG, "Registering user failed", task.getException());
    Toast.makeText(Register_User.this, "Failed to Registered", Toast.LENGTH_SHORT).show();
}