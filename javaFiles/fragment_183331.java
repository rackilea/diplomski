public void readContact(long position) throws IOException {
        raf.seek(position);
        String name = FixedLengthStringIO.readFixedLengthString(
                NAME_SIZE, raf);
        String type = FixedLengthStringIO.readFixedLengthString(
                TYPE_SIZE, raf);
        String city = FixedLengthStringIO.readFixedLengthString(
                CITY_SIZE, raf);
        String phone = FixedLengthStringIO.readFixedLengthString(
                PHONE_SIZE, raf);
        String email = FixedLengthStringIO.readFixedLengthString(
                EMAIL_SIZE, raf);

        jbtName.setText(name);
        jbtType.setText(type);
        jbtCity.setText(city);
        jbtPhone.setText(phone);
        jbtEmail.setText(email);

    }