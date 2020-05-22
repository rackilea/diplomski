System.out.println("\t output switch =  " + state.get(2));
switch(state.get(2)){
    //Case MCNP
    case 0:
    {
        abundances = verifyAndNorm(abundances, new MCNPVerifier(MCNP));
        out = toMCNP(mat, abundances);
        System.out.println("\t MCNP");
        break;
    }

    //Case SCALE
    case 1:
    {
        abundances = verifyAndNorm(abundances, new SCALEVerifier(SCALE));
        out = toSCALE(mat, abundances, weightFracFlag);
        System.out.println("\t SCALE");
        break;
    }
    default:
}