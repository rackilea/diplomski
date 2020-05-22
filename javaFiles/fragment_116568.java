const regex = /\[(School_Teacher_Name)]/gm;
const str = `[School_Teacher_Name] is our new member, So please congratulate [School_Teacher_Name] .`;
const subst = `Yash Mathur`;

// The substituted value will be contained in the result variable
const result = str.replace(regex, subst);

console.log('Substitution result: ', result);