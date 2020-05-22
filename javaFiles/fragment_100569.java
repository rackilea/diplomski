particle type;
switch (enemy_composition) { /* Assuming "nature" is an enum. */
  case ANTIMATTER : 
    type = particle.proton;
    break;
  case MATTER : 
    type = particle.antiproton;
    break;
}
DeathRay mynewWpn = new DeathRay(type, chassisColor.BLACK, oem.ACME);