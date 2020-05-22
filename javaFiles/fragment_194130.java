----> CREATE TABLE projects(
   id INTEGER PRIMARY KEY AUTOINCREMENT     NOT NULL,
   name           TEXT    NOT NULL,
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)
----> CREATE INDEX ix_tasks_project_id ON tasks (project_id)
----> SELECT * FROM projects WHERE name = "someName;WithSemiColon"