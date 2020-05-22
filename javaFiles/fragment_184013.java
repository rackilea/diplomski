final Collection<KiePackage> kiePackages = kieSession.getKieBase().getKiePackages();
for (KiePackage kiePackage : kiePackages)
{
    final Collection<Global> globalVariables = kiePackage.getGlobalVariables();
    //...
}