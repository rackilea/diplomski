const pattern = /\[[^_]+_[^_]+\]|\{[^_]+_[^_]+\}/;

// matches
console.log(pattern.test('[1Ab_23c]'));
console.log(pattern.test('{1Abdefg4567_2}'));
console.log(pattern.test('{1Ab_23c}'));

// mismatches
console.log(pattern.test('{1Ab_23c]'));
console.log(pattern.test('{_1Abde_fg4567_2_}'));
console.log(pattern.test('{1Abde_fg4567_2}'));
console.log(pattern.test('1Ab_23c'));