function toObject(string) {
    "use strict";
    const tokens = string.match(/[\[\]]|[^\s\[\]]+/g),
        result = [];
    let i = 0;
    function recurse() {
        const words = [];
        let obj;
        while (i < tokens.length) {
            let token = tokens[i];
            if (token[0] === '@') {
                obj = {name: token};
                result.push(obj);
            } else if (token === '[') {
                i++;
                obj.text = recurse();
                words.push(obj.text);
            } else if (token === ']') {
                break;
            } else {
                words.push(token);
            }
            i++;
        }
        return words.join(' ');
    }
    recurse();
    return result;
}

const string = "@anno1[ data1 xyz @anno2[data2  @anno3[data3] data4] data5 @anno4[data6] data7]";
const result = toObject(string);
console.log(result);