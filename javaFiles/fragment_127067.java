// affichage de la liste déroulante
    Spinner spi = (Spinner) row.findViewById(R.id.spiListeChoix);
    ChoixPointVerificationDal choixPointVerificationDal = new ChoixPointVerificationDal();
    List<ChoixPointVerification> listeChoixPointVerification;
    try {
        listeChoixPointVerification = choixPointVerificationDal
                .GetByIdPointVerification(mChoixPointVerificationDao,
                        getItem(position).id);

        List<String> pointVerifications = new ArrayList<String>();
        for(ChoixPointVerification choixPointVerification: listeChoixPointVerification)
        {
            pointVerifications.add(choixPointVerification.nom);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item,
                pointVerifications);

        spi.setAdapter(adapter);

    } catch (SQLException e) {
        e.printStackTrace();
    }