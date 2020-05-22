global Integer count;

rule "Initialize"
salience 100
when
then
       kcontext.getKieRuntime().setGlobal("count", 1);
end