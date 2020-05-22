TransActionInfo info = getMoney(500000);
switch (info.getStatus()) {
  case: Status.OK: 
     break;
  case Status.LIMIT_EXCEEDED:
    // inform on display of bankomat. or similar
     break;
  ...
}