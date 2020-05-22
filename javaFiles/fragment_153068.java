@Transactional
Object thirdMethod(){
   Object res = pjp.proceed();
   additionalService.additionalAction();
   return res;
}