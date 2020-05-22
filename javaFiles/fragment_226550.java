final public class SplitStr 
{
    private static void strDump(String[] arr)
    {
        for (String s : arr) {
            System.out.format("[%s]", s);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        strDump("1,234,567,890".split(","));
        // "[1][234][567][890]"
        strDump("1,234,567,890".split("(?=,)"));    
        // "[1][,234][,567][,890]"
        strDump("1,234,567,890".split("(?<=,)"));   
        // "[1,][234,][567,][890]"
        strDump("1,234,567,890".split("(?<=,)|(?=,)"));
        // "[1][,][234][,][567][,][890]"

        strDump(":a:bb::c:".split("(?=:)|(?<=:)"));
        // "[][:][a][:][bb][:][:][c][:]"
        strDump(":a:bb::c:".split("(?=(?!^):)|(?<=:)"));
        // "[:][a][:][bb][:][:][c][:]"
        strDump(":::a::::b  b::c:".split("(?=(?!^):)(?<!:)|(?!:)(?<=:)"));
        // "[:::][a][::::][b  b][::][c][:]"
        strDump("a,bb:::c  d..e".split("(?!^)\\b"));
        // "[a][,][bb][:::][c][  ][d][..][e]"

        strDump("ArrayIndexOutOfBoundsException".split("(?<=[a-z])(?=[A-Z])"));
        // "[Array][Index][Out][Of][Bounds][Exception]"
        strDump("1234567890".split("(?<=\\G.{4})"));    
        // "[1234][5678][90]"

        // Split at the end of each run of letter
        strDump("Boooyaaaah! Yippieeee!!".split("(?<=(?=(.)\\1(?!\\1))..)"));
        // "[Booo][yaaaa][h! Yipp][ieeee][!!]"
    }
}