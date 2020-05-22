Calendar stored = Calendar.getInstance();

long a = sp.getLong("date", 0);

stored.set(0,0,0,0,0);

stored.add(Calendar.MILLISECOND, a);