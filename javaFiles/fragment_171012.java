public CandidateList(){
    candidates = new String[0];
}

public CandidateList(String[] candidates){

    // you are doing the same error as above here:
    // when you do this you create an EMPTY list of size candidates.lenght
    // correct code is this.candidates = candidates
    this.candidates = new String[candidates.length];

    // this is not necessary, constructors don't need to return anything, 
    //here you are just creating a new instance that will not be used anywhere
    CandidateList candidateList = new CandidateList();