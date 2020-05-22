import org.crsh.cli.Command;
import org.crsh.cli.Usage;
import org.crsh.command.Pipe;
import org.crsh.cli.Argument;

class bfilter {
 @Usage("Filters output of beans")
    @Command
    Pipe<Object,Object> main(
    @Usage("regex of bean names to find")
    @Argument String regex) {
        return new Pipe<Object, Object>(){
            public void provide(Object result) {
                def bean = []
                for(entry in result){
                    for(aBean in entry.beans){
                        if(aBean.bean.matches(regex)){
                            bean << aBean
                        }
                    }

                }
                context.provide(bean)
            }
        };
    }
}