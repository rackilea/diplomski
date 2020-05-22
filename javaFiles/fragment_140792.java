CREATE TABLE USER_CONVERSATIONS
(
  conversation_id  INT   NOT NULL  IDENTITY(1,1)   PRIMARY KEY,
  [user_id]        INT,
  message          VARCHAR(255)
)

INSERT INTO USER_CONVERSATIONS
(
  user_id,
  message
)
SELECT
   user_id,
   'Hello World!'
FROM USERS;