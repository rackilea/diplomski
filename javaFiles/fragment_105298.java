function formToJSON() {

  var test = {  empno:7876, ename:'ADAMS', job:1100, sal:7788,
                 deptNo:{deptNo:6, dname:'RESEARCH', loc:'DALLAS'}
               };

    return JSON.stringify(test);

    }