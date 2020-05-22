boolean isEnabled = true;
switch (cStatus) {

  case PEN:
    switch (nStatus) {
     case ACT:
     case SUS:
     case PEN_CAN:
        isEnabled = false;
    }
    break;
  case ACT:
    switch (cStatus) {
      ...
    }
    break;
}