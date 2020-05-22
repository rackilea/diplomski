for (int i = 0; i < persons.size(); i++)
        {
            Person per1 = persons.get(i);

            for (ListIterator<Person> iter = persons.listIterator(i); iter.hasNext(); )
            {
                Person per2 = iter.next();
                if (per1 != per2 &&
                    per1.getName().equals(per2.getName()))
                {
                    per1.setSalary(per1.getSalary() + per2.getSalary());
                    iter.remove();
                }
            }
        }