case R.id.btnSearch:
            Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(intent);
            break;

        case R.id.btnSignout:
            mAuth.signOut();
            Intent signInIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(signInIntent);
            finish();
            break;