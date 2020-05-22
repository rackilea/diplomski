CREATE TABLE "users"
    (
user_id SERIAL PRIMARY KEY NOT NULL,
user_email VARCHAR(255) NOT NULL,
user_password VARCHAR(255) NOT NULL,
user_role VARCHAR(255)
   );