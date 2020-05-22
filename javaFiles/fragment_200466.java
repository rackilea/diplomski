function swapInput()
{
    var input_a =document.getElementById('addContactRelationshipForm:contactName1_input').value; 
    var input_b =document.getElementById('addContactRelationshipForm:contactName2_input').value;

    document.getElementById('addContactRelationshipForm:contactName1_input').value = input_b;
    document.getElementById('addContactRelationshipForm:contactName2_input').value = input_a;
}