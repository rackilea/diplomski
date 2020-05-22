ALTER TABLE t ADD COLUMN user_name text;

-- and in the trigger (depending on context):

my_user := NEW.user_name;
or
my_user := OLD.user_name;