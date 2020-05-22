const tests = [
  'app1_1.0_prod1.properties',
  'app2_2_prod2.properties',
  'app_vers1_prod.properties',
  'asd_efg_eee.properties',
  'abc.properties',
  'abc.123.efg.properties',
  'as_1.efg.ddd.rr.properties',
  'ee_rr.properties',
  '_rr_.properties'
];

tests.forEach(test => { 
  console.log(test, /^[^_]+_[^_]+_[^_]+\.properties$/.test(test)); 
});