public java.lang.String toString() {
return String.format(
"$classname (##
#set ($i = 0)
#foreach ($member in $members)
#if ($i != 0)##
, ##
#end
$member.name=%s##
#set ($i = $i + 1)
#end
)",##
#set ($i = 0)
#foreach ($member in $members)
    #if ($i != 0)
    ,##
    #end
    #if ($member.primitiveArray || $member.objectArray)
    java.util.Arrays.toString(this.$member.name)##
    #else
    this.$member.name ##
    #end
    #set ($i = $i + 1)
#end
);
}