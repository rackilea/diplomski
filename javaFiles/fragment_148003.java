Intent returnIntent = new Intent();
            returnIntent.putExtra("name", m.getName());
            returnIntent.putExtra("unit", m.getUnit());
            returnIntent.putExtra("quantity", m.getQuantity());
            if (getParent() == null) {
                setResult(Activity.RESULT_OK, returnIntent);
            } else {
                getParent().setResult(Activity.RESULT_OK, returnIntent);
            }
            finish();