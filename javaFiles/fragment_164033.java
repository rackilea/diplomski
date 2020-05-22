public class ServiceImpl {
  ...
  if (entity.getStatus) == 'A' then
    finalStatus = handleA();
  else if (entity.getStatus() == 'B') then
    finalStatus = handleB();
  else
    finalStatus = handleEverythingElse();
  ...
}