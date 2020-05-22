class MemberCounter {
  int numDemocrats;
  int numRepblican;
  int numIndepent;
};

MemberCounter countMembers(List<MemberOfCongress> members) {
  MemberCounter counter = new MemberCounter();

  for (MemberOfCongress party : members) {
    if (party.getParty().equals("D")) {
      counter.numDemocrats++;
    }
    else if (party.getParty().equals("R")){
      counter.numRepblican++;
    }
    else if (party.getParty().equals("I")){
      counter.numIndepent++;
    }
  }

  return counter;
}