<s:select label="Pick the company name" 
    headerKey="-1" headerValue="Select Company name"
    list="%{companyMap.entrySet()}" 
    name = "companyId"
    listKey="value"
    listValue="key"
/>