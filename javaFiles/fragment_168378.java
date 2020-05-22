import re

regex = re.compile('@test\\s+([:.\\w\\\\x7f-\\xff]+)(?:[\\t ]+(\\S*))?(?:[\\t ]+(\\S*))?\\s*$', re.MULTILINE)
s1 = '    /**\n     * @test     TestGroup\n     */\n'
s2 = 'foo @test : bar baz';

match = re.search(regex, s1)
for i in range(regex.groups + 1):
    print('Group {}: {}'.format(i, match.group(i)))
print()

match = re.search(regex, s2)
for i in range(regex.groups + 1):
    print('Group {}: {}'.format(i, match.group(i)))